(ns sicp-clj.keep)

; duplicates even? - but for illustration...
(defn is-even? [x]
  (zero? (rem x 2)))

(defn evens [nums]
  (cond (empty? nums) 
          '()
        (is-even? (first nums)) 
          (cons (first nums) (evens (rest nums)))
        :else (evens (rest nums))))

; Illustrates recursion and matches teaching example, but of course more
; idiomatically as (though this is foreshadowing):
(defn evens-filt [coll]
  (filter even? coll))

; With strings/chars
(defn has-char? [s c]
  (.contains s (str c)))

(defn e-words [sent]
  (cond (empty? sent)
          '()
        (has-char? (first sent) \e)
          (cons (first sent) (e-words (rest sent)))
        :else (e-words (rest sent))))
;; e-words '("yes" "no" "you've" "got")
; ("yes" "you've")

; General case is:
(defn keep-if [pred? sent]
  (cond (empty? sent)
          '()
        (pred? (first sent))
          (cons (first sent) (keep-if pred? (rest sent)))
        :else (keep-if pred? (rest sent))))

; Defined with keep-if
(defn keep-evens [sent]
  (keep-if is-even? sent))

; Tweak pred? to check for e
(defn has-e? [s]
  (has-char? s \e))

; Then same for e-words
(defn keep-if-eword [sent]
  (keep-if has-e? sent))

; lambda repl examples:
(defn keep-if-fl-same [sent]
  (keep-if #(= (first %) (last %)) sent))
;; (keep-if-fl-same '("alabama" "colorado"))
; ("alabama")

; Simple def of compose:
(defn compose [f g]
 #(f (g %)))

; ...turns out to be a fairly powerful abstraction.
(def get-second (compose first rest))
