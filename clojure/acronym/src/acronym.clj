(ns acronym 
  (:require
   [clojure.string :as string]))

(defn acronym
  "Converts phrase to its acronym."
  [phrase]
  (->> (re-seq #"[A-Z]+[a-z]*|[a-z]+" phrase)
       (map first)
       (apply str)
       string/upper-case))

