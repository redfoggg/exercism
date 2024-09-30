(ns squeaky-clean
  (:require [clojure.string :as str]))

(defn clean
  "TODO: add docstring"
  [s]
  (-> s
      (str/replace #" " "_")
      (str/replace #"[0-9]" "")
      (str/replace #"-[\p{Ll}\p{Lu}]" #(str/upper-case (second %)))
      (str/replace #"[\u0000-\u001F\u007F-\u009F]" "CTRL")
      (str/replace #"[^\p{L}\p{N}_]" "")
      (str/replace #"[α-ω]" "")))

