(ns examples.go
  (:require
    [clojure.core.async :refer (put! alts!! close!)]))

(def a (chan))
(def b (chan))

(put! a 42)

; will return [42 channel-first-responded]
(alts!! [a b])
