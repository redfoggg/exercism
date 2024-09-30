(ns elyses-destructured-enchantments)

(defn first-card
  "Returns the first card from deck."
  [deck]
  (first deck))

(defn second-card
  "Returns the second card from deck."
  [deck]
  (second deck))

(defn swap-top-two-cards
  "Returns the deck with first two items reversed."
  [deck]
  (let [first-card                    (first-card deck)
        second-card                   (second-card deck)
        deck-without-first-and-second (drop 2 deck)]
    (concat [second-card first-card] deck-without-first-and-second)))

(defn discard-top-card
  "Returns a sequence containing the first card and
   a sequence of the remaining cards in the deck."
  [deck]
  [(first deck) (next deck)])

(def face-cards
  ["jack" "queen" "king"])

(defn insert-face-cards
  "Returns the deck with face cards between its head and tail."
  [deck]
  (if (seq deck)
    (concat [(first deck)] face-cards (rest deck))
    face-cards))

