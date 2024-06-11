(ns bird-watcher)

(def last-week
  [0 2 5 3 7 8 4])

(defn today [birds]
  (last birds))

(defn inc-bird [birds]
  (let [today-birds (today birds)
        incremented-day (inc (or today-birds 0))]
    (conj (pop birds) incremented-day)))

(defn day-without-birds? [birds]
  (some? (some #(= % 0) birds)))

(defn n-days-count [birds n]
  (reduce + 0 (take n birds)))

(defn busy-days [birds]
  (count (filter #(>= % 5) birds)))


(defn odd-week? [birds]
  (= birds [1 0 1 0 1 0 1]))
