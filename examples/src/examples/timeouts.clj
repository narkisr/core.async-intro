(ns examples.go
  (:require
    [clojure.core.async :refer (put! alts!! close! timeout)]))

(def a (chan))
(def b (chan))

(<!! (timeout 1000))

(alts!! [a (timeout 1000)])


