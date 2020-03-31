(ns kitchen-3)

(defn create-drink [flavour] (conj [] flavour))
(defn with-water
  [drink water]
  (if (clojure.string/includes? water "hot")
      (conj drink water)
      (nil)))
(defn with-milk
  [drink milk]
  (if-not (clojure.string/includes? milk "sour")
          (conj drink milk)
          (nil)))
(defn with-sugar
  [drink sugar]
  (if-not (clojure.string/includes? sugar "salt")
          (conj drink sugar)
          (nil)))

(defn stir [drink] (shuffle drink))

(defn make-drink [tea water milk sugar]
  (some-> (create-drink tea)
          (with-water water)
          (with-milk milk)
          (with-sugar sugar)
          (stir)))

(defn -main []
  (do
    (if-let
      [drink (make-drink "tea" "hot water" "semi-skimmed" "one lump")]
      (println drink)
      (println "Your drink could not be made"))
    (if-let
      [drink (make-drink "tea" "hot water" "semi-skimmed" "salt")]
      (println drink)
      (println "Your drink could not be made"))
    (if-let
      [drink (make-drink "tea" "hot water" "sour milk" "one lump")]
      (println drink)
      (println "Your drink could not be made"))))
