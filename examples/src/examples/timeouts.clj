(ns examples.go
  (:require
    [clojure.core.async :refer (put! alts!! close! timeout)]))

(def a (chan))
(def b (chan))

(<!! (timeout 1000))

; [nil, timeout-channel]
(alts!! [a (timeout 1000)])

; put into a -> no takers so [nil, timeout-channel]
(alts!! [[a 42] (timeout 1000)])

; [:meh :default]
(alts!! [a] :default :meh) 

