(ns examples.callbacks
  (:require
   [clojure.core.async :refer (<!! >!! <! >! chan take! put!)] )
 )

(def c (chan))

(take! c (fn [v] (println v)))

(put! c "hello world" (fn [v]  (println "Data delivered!")))
