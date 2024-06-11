(ns cars-assemble)

(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  (int ((* speed (/ 221 60)))))

(defn- working-items-per-hour
  [speed]
  (* (working-items speed) 60))

(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (cond (== speed 0) 0
        (< speed 5) (working-items-per-hour speed)
        (< speed 9) (* (working-items-per-hour speed) 0.9)
        (== speed 9) (* (working-items-per-hour speed) 0.80)
        (== speed 10) (* (working-items-per-hour speed) 0.77)))


