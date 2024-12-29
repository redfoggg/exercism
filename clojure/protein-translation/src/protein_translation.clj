(ns protein-translation)

(defn translate-codon
  [codon]
  (cond
    (re-find #"AUG" codon) "Methionine"
    (re-find #"UUU|UUC" codon) "Phenylalanine"
    (re-find #"UUA|UUG" codon) "Leucine"
    (re-find #"UCU|UCC|UCA|UCG" codon) "Serine"
    (re-find #"UAU|UAC" codon) "Tyrosine"
    (re-find #"UGU|UGC" codon) "Cysteine"
    (re-find #"UGG" codon) "Tryptophan"
    (re-find #"UAA|UAG|UGA" codon) "STOP"))

(defn rna->codons
  [rna]
  (re-seq #"AUG|UUU|UUC|UUA|UUG|UCU|UCC|UCA|UCG|UAU|UAC|UGU|UGC|UGG|UAA|UAG|UGA" rna))

(defn translate-rna
  [rna]
  (let [codons (rna->codons rna)]
    (loop [proteins      ()
           left-codons   codons]
      (cond
        (some #(= % "STOP") proteins) (filter #(not= % "STOP") (reverse proteins))
        (empty? left-codons)          (reverse proteins)
        :else                         (recur (conj proteins (translate-codon (first left-codons)))
                                             (rest left-codons))))))
