(ns binary-search)

(defn middle [upper bottom]
  (quot (+ upper bottom) 2))

(defn search-for
  ([item coll]
   (search-for item coll (- (count coll) 1) 0))
  ([item coll upper bottom]
   (let [middle-index (middle upper bottom)]
     (cond
       (or (empty? coll)
           (not (<= bottom upper))) (throw (Exception. "not found"))
       (= item (nth coll middle-index))                       middle-index
       (> item (nth coll middle-index))                       (search-for item coll upper (inc middle-index))
       :else                                                  (search-for item coll (dec middle-index) bottom)))))

