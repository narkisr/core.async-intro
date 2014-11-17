(ns examples.go
  (:require
    [clojure.core.async :refer (<!! >!! <! >! chan close!)]))

(def c (chan))

(close! c)

; we get back nil
(<!! c)
