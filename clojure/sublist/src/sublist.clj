(ns sublist)

(defn ^:private sublist? [list1 list2]
  (some #{list1} (partition (count list1) 1 list2)))

(defn ^:private superlist? [list1 list2]
  (sublist? list2 list1))

(defn classify [list1 list2] ;; <- arglist goes here
  (cond
    (= list1 list2)        :equal
    (sublist? list1 list2) :sublist
    (superlist? list1 list2) :superlist
    :else :unequal))


