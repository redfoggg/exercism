(ns pig-latin
  (:require
   [clojure.string :as str]))

(defn ^:private rule-1
  [word]
  (str word "ay"))

(defn ^:private rule-2
  [word]
  (as-> word w
    (re-seq #"^[^aeiouAEIOU]+|.+" w)
    (str (second w) (first w))
    (rule-1 w)))

(defn ^:private rule-3
  [word]
  (as-> word w
    (re-seq #"^[^aeiouAEIOU]*qu|.*" w)
    (str (second w) (first w))
    (rule-1 w)))

(defn ^:private rule-4
  [word]
  (as-> word w
    (re-seq #"^[^aeiouAEIOUyY]+|y|.*" w)
    (str (second w) (nth w 2) (first w))
    (rule-1 w)))

(defn translate-word [word]
  (cond
    (re-find #"^(xr|yt|[aeiouAEIOU]).*" word) (rule-1 word)
    (re-find #"^[^aeiouAEIOU]*qu" word)       (rule-3 word)
    (re-find #"^[^aeiouAEIOU]*y"  word)       (rule-4 word)
    (re-find #"^[^aeiouAEIOU]+" word)         (rule-2 word)))

(defn translate [phrase]
  (->> (str/split phrase #"\s+")
       (map translate-word)
       (str/join " ")))

