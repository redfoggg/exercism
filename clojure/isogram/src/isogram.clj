(ns isogram 
  (:require
   [clojure.string :as string]))

(defn isogram?
  [word]
  (not (boolean (re-find #"(\p{L}).*\1" (string/lower-case word)))))

