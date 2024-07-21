(ns cars-assemble)

(defn- working-items-per-hour
  [speed]
  (* 221 speed))

(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  (let [cars-produced (/ (working-items-per-hour speed) 60)]
    (int (cond (< speed 5) cars-produced
               (< speed 9) (* cars-produced 0.9)
               (== speed 9) (* cars-produced 0.80)
               (== speed 10) (* cars-produced 0.77)))))

(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (cond (< speed 5) (working-items-per-hour speed)
        (< speed 9) (* (working-items-per-hour speed) 0.9)
        (== speed 9) (* (working-items-per-hour speed) 0.80)
        (== speed 10) (* (working-items-per-hour speed) 0.77)))
