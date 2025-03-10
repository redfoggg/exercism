(ns question-4-1.core
  (:gen-class))

;; mais inteligente vai ser resolver todos aqui ao invés de ficar criando vários projetos...

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  nil)

(defn sum ;; 4.1
  [arr]
  (loop [arr arr
         acc 0]
    (if (empty? arr)
      acc
      (recur (rest arr) (+ (first arr) acc)))))

(sum [1 2 3])

(defn count-v
  [arr] ;; 4.2
  (loop [arr arr
         acc 0]
    (if (empty? arr)
      acc
      (recur (rest arr) (inc acc)))))

(count-v [1 2 3 4 5])

(defn max-v
  [arr] ;; 4.3
  (loop [arr arr
         max-value (first arr)]
    (if (empty? arr)
      max-value
      (if (> (first arr) max-value)
        (recur (rest arr) (first arr))
        (recur (rest arr) max-value)))))

(max-v [1 2 3 7 4])

(defn binary-search
  [arr key] ;; 4.4
  (loop [arr arr]
    (let [mid-index (int (/ (dec (count arr)) 2))]
      (cond
        (and (nil? (next arr))
             (not= key (first arr))) "Not found"
        (= key (nth arr mid-index)) (str "found: " key)
        (> key (nth arr mid-index)) (recur (subvec arr (inc mid-index)))
        (< key (nth arr mid-index)) (recur (subvec arr 0 (inc mid-index)))))))

(binary-search [1 2 3 4 5 6 7 8] 9)

(defn quick-sort-depois
  [arr]
  (if (< (count arr) 2)
    arr
    (loop [arr arr
	   acc []]
      (let [pivot (first arr)
	    lower-half (filter #(< % pivot) arr)
	    upper-half (filter #(> % pivot) arr)]
	(cond
	  (not= empty? lower-half) (recur lower-half (conj lower-half pivot))
	  (not= empty? upper-half) (recur upper-half (conj pivot upper-half))
	  nil (conj lower-half pivot upper-half))))))

(defn quick-sort
  [arr]
  (if (< (count arr) 2)
    arr
    (let [pivot (first arr)
	  lower-half (filter #(< % pivot) arr)
	  upper-half (filter #(> % pivot) arr)]
      (concat (quick-sort lower-half) [pivot] (quick-sort upper-half)))))

(quick-sort [5 4 1 2 3])
