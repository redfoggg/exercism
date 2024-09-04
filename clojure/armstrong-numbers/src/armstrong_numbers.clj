(ns armstrong-numbers)

(defn ^:private power [a b]
  (Math/pow a b))

(defn ^:private digits [n]
  (if (pos? n)
    (conj (digits (quot n 10)) (mod n 10))
    []))

(defn armstrong? [num]
  (let [digits-vector                        (digits num)
        armstrong-potency                    (count digits-vector)
        digits-vector-power-by-length-of-num (map #(int (power %1 armstrong-potency)) digits-vector)]
    (= (reduce + 0 digits-vector-power-by-length-of-num) num)))

