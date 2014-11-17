(ns examples.fbc
  (:require
    [clojure.core.async :refer (<!! >!! <! >! dropping-buffer go)]))

(def dbc (chan (dropping-buffer 1)))

(go (>! dbc 1)
    (println "done"))

(go (>! dbc 2)
    (println "done"))

(<!! dbc)
