(ns fatorial)

(defn fatorial
  [n]
  (loop [n n
         acc 1]
    (if (<= n 1)
      acc
      (recur (dec n) (* n acc)))))


(fatorial 5)
