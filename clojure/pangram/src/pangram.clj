(ns pangram
  (:require
   [clojure.string :as str]))

(def alphabet-frequency-vector (frequencies "abcdefghijklmnopqrstuvwxyz"))

(defn ^:private letter-frequency-vector
  [letters]
  (let [filtered-letters  (filter #(Character/isLetter %) (str/lower-case letters))
        letters-frequency (frequencies filtered-letters)]
    letters-frequency))

(defn pangram? [phrase]
  (let [phrase-frequency-vector   (letter-frequency-vector phrase)]
    (= (keys alphabet-frequency-vector) (keys phrase-frequency-vector))))


(comment
  (ns pangram
  [:require [clojure.string :as str]])
(defn pangram? [sentence]
  (->> sentence
       (str/lower-case)
       (re-seq #"[a-z]")
       set
       count
       (= 26)))
  )
