(ns kitchen-2)


(defn create-drink [flavour] (conj [] flavour))


(defn with-water [drink water] (conj drink water))


(defn with-milk [drink milk] (conj drink milk))


(defn with-sugar [drink sugar] (conj drink sugar))


(defn stir [drink] (shuffle drink))


(defn make-drink [tea water milk sugar]
  (-> (create-drink tea)
      (with-water water)
      (with-milk milk)
      (with-sugar sugar)
      (stir)))


(defn -main [] (make-drink "tea" "water" "semi-skimmed" "one lump"))


