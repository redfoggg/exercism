(ns selection-sort)

(defn selection-sort [v]
  (let [n (count v)]
    (loop [i 0
           sorted-vec v]
      (if (< i n) ;; break condition, aqui se o i estiver no mesmo passo do tamanho n, para a recursão
        (let [min-idx (loop [j i
                             min-val (sorted-vec i)
                             min-pos i]
                        (if (< j n)
                          (if (< (sorted-vec j) min-val)
                            (recur (inc j) (sorted-vec j) j)
                            (recur (inc j) min-val min-pos))
                          min-pos))] ;;isso aqui é o mesmo que a função busca-menor do livro
          (recur (inc i) (assoc sorted-vec i (sorted-vec min-idx) min-idx (sorted-vec i))))
        sorted-vec))))

(selection-sort [3 1 4 7 2])
