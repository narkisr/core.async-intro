(ns examples.fbc
  (:require
    [clojure.core.async :refer (<!! >!! <! >! chan go)]))

(def fbc (chan 1))

(go (>! fbc 1)
    (println "done"))

(go (>! fbc 2)
    (println "done"))

(<!! fbc)
(<!! fbc)
