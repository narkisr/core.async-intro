(ns examples.mult
  (:require
    [clojure.core.async :refer (<! >!! chan mult tap go close!)]))


(def to-mult (chan 1))
(def m (mult to-mult))

(dotimes [n 4]
  (let [c (chan 1)]
   (tap m c)
   (go 
     (while true
       (when-let [v (<! c)]
         (println "Got! " v))
      (println "Exiting!")))))

(>!! to-mult 42)
(>!! to-mult 43)

(close! to-mult)
