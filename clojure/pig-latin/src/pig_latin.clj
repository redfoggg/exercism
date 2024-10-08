(ns pig-latin 
  (:require
   [clojure.string :as str]))

(defn ^:private rule-1
  [word]
  "rule-1")

(defn ^:private rule-2
  [word]
  "rule-2")

(defn ^:private rule-3
  [word]
  "rule-3")

(defn ^:private rule-4
  [word]
  "rule-4")

(defn translate [word]
  (cond 
    (or (re-find #"^a|e|i|o|u" word)
        (str/starts-with? "xr" word)
        (str/starts-with? "yt" word)) (rule-1 word)
    
    (= 1 1) (rule-4 word)))


(translate "apple")
(translate "earay")
(pig-latin/translate "igloo")
(pig-latin/translate "object")
(pig-latin/translate "under")
(pig-latin/translate "pig")
