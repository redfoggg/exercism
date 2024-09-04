(ns triangle)

(defn is-valid? [a b c] ;; <- arglist goes here
  (and (> a 0)
       (> b 0)
       (> c 0)
       (>= (+ a b) c)
       (>= (+ b c) a)
       (>= (+ c a) b)))

(defn equilateral? [a b c] ;; <- arglist goes here
  (if (is-valid? a b c)
    (= a b c)
    false))

(defn isosceles? [a b c] ;; <- arglist goes here
  (if (is-valid? a b c)
    (or (= a b)
        (= a c)
        (= b c))
    false))

(defn scalene? [a b c] ;; <- arglist goes here
  (if (is-valid? a b c)
    (and (not= a b)
         (not= b c))
    false))
