(ns kitchen-1)

(defn create-drink [flavour] (conj [] flavour))
(defn with-water [drink water] (conj drink water))
(defn with-milk [drink milk] (conj drink milk))
(defn with-sugar [drink sugar] (conj drink sugar))
(defn stir [drink] (shuffle drink))

(defn make-drink [tea water milk sugar]
  (let [step1 (create-drink tea)
        step2 (with-water step1 water)
        step3 (with-milk step2 milk)
        step4 (with-sugar step3 sugar) ]
    (stir step4)))

(defn -main [] (make-drink "tea" "water" "semi-skimmed" "one lump"))


