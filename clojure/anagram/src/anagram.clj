(ns anagram
  (:require
   [clojure.string :as string]))

(defn ^:private same-frequency?
  [word prospect]
  (= (frequencies (string/lower-case word)) (frequencies (string/lower-case prospect))))

(defn ^:private anagram-for
  [word prospect]
  (when (and (same-frequency? word prospect) (not= (string/lower-case word) (string/lower-case prospect)))
    (let [word-insensitive-set (set (string/lower-case word))
          prospect-insensitive (string/lower-case prospect)]
      (if (every? word-insensitive-set prospect-insensitive)
        (apply str prospect)
        []))))

(defn anagrams-for [word prospect-list]
  (filter #(seq %)
          (vec (map (partial anagram-for word) prospect-list))))

(comment
  "solução mais elegante da galera do exercism"
  (ns anagram
    (:require [clojure.string :as str]))
  (defn are-anagrams? [s1 s2]
    (let [x (str/lower-case s1)
          y (str/lower-case s2)]
      (and (not= x y)
           (= (sort x) (sort y)))))
  (defn anagrams-for [str candidates]
    (filter (partial are-anagrams? str) candidates)))
