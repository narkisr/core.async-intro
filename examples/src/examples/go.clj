(ns examples.go
  (:require
    [clojure.core.async :refer (<!! >!! <! >! chan go)]))

; returns many to many channel
(go 42)

(<!! (go 42))

; notice the use of <!
(<!! (go (println "It works!" (<! (go 42)))))

