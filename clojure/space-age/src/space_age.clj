(ns space-age)

(defn on-mercury
  [seconds]
  (/ seconds (* 31557600 0.2408476)))

(defn on-venus
  [seconds]
  (/ seconds (* 31557600 0.61519726)))

(defn on-earth
  [seconds]
  (/ seconds 31557600))

(defn on-mars
  [seconds]
  (/ seconds (* 31557600 1.8808158)))

(defn on-jupiter
  [seconds]
  (/ seconds (* 31557600 11.862615)))

(defn on-saturn
  [seconds]
  (/ seconds (* 31557600 29.447498)))

(defn on-uranus
  [seconds]
  (/ seconds (* 31557600 84.016846)))

(defn on-neptune
  [seconds]
  (/ seconds (* 31557600 164.79132)))

