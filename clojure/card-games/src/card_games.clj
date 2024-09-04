(ns card-games)

(defn rounds
  "Takes the current round number and returns 
   a `list` with that round and the _next two_."
  [n]
  (conj '() (inc (inc n)) (inc  n) n))

(defn concat-rounds
  "Takes two lists and returns a single `list` 
   consisting of all the rounds in the first `list`, 
   followed by all the rounds in the second `list`"
  [l1 l2]
  (concat l1 l2))

(defn contains-round?
  "Takes a list of rounds played and a round number.
   Returns `true` if the round is in the list, `false` if not."
  [l n]
  (boolean (some #{n} l)))

(defn card-average
  "Returns the average value of a hand"
  [hand]
  (float (/ (reduce + hand) (count hand))))

(defn approx-average?
  "Returns `true` if average is equal to either one of:
  - Take the average of the _first_ and _last_ number in the hand.
  - Using the median (middle card) of the hand."
  [hand]
  (let [average-of-first-last-list (card-average (list (first hand) (last hand)))
        middle-card                (nth hand (int (/ (count hand) 2)))]
    (or (== (card-average hand) average-of-first-last-list)
        (== (card-average hand) middle-card))))

(defn average-even-odd?
  "Returns true if the average of the cards at even indexes 
   is the same as the average of the cards at odd indexes."
  [hand]
  (let [even-indexed-cards (take-nth 2 hand)
        odd-indexed-cards  (take-nth 2 (rest hand))]
    (== (card-average even-indexed-cards) (card-average odd-indexed-cards))))

(defn maybe-double-last
  "If the last card is a Jack (11), doubles its value
   before returning the hand."
  [hand]
  (if (== (last hand) 11)
    (concat (drop-last hand) (list (* (last hand) 2)))
    hand))
