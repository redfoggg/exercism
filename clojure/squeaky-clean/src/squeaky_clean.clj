(ns squeaky-clean
  (:require [clojure.string :as str]))

(defn clean
  "TODO: add docstring"
  [s]
  (-> s
      (str/replace #" " "_")
      (str/replace #"-" "_")
      (str/replace #"[0-9]" "")))
