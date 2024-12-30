(ns say)

(def basic-digits
  {0 :zero
   1 :one
   2 :two
   3 :three
   4 :four
   5 :five
   6 :six
   7 :seven
   8 :eight
   9 :nine})

(defn step-1
  [num]
  (cond
    (and (>= num 20) (< num 30))  :twenty
    (and (>= num 30) (< num 40))  :thirty
    (and (>= num 40) (< num 50))  :forty
    (and (>= num 50) (< num 60))  :fifty
    (and (>= num 60) (< num 70))  :sixty
    (and (>= num 70) (< num 80))  :seventy
    (and (>= num 80) (< num 90))  :eighty
    (and (>= num 90) (< num 100)) :ninety))

(defn step-2
  [num]
  ())

(defn number
  [num]
  ())


