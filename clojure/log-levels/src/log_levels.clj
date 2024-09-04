(ns log-levels
  (:require [clojure.string :as str]))

(defn message
  "Takes a string representing a log line
   and returns its message with whitespace trimmed."
  [s]
  (-> s
      (str/split #":")
      second
      str/trim))

(defn log-level
  "Takes a string representing a log line
   and returns its level in lower-case."
  [s]
  (as-> s v
    (str/split v #":")
    (first v)
    (subs v 1 (dec (count v)))
    (str/lower-case v)))

(defn reformat
  "Takes a string representing a log line and formats it
   with the message first and the log level in parentheses."
  [s]
  (let [message                   (message s)
        log-level                 (log-level s)
        log-level-inside-brackets (str " (" log-level ")")]
    (str message log-level-inside-brackets)))
