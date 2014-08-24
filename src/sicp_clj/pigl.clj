(ns sicp-clj.pigl)

(defn vowel? [l]
  (contains? #{\a \e \i \o \u} l))

(defn pl-done? [wd]
  (vowel? (first wd)))

(defn word [ls]
  (apply str ls))

(defn pigl [wd]
  (if (pl-done? wd)
    (word [wd \a \y])
    (pigl (word (conj
                  (into [] (rest wd))
                  (first wd))))))

