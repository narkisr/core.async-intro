(ns examples.blocking
  (:require
    [clojure.core.async :refer (<!! >!! chan thread)]))

(def c (chan))

(future (println "Done" (>!! c 42)))

(future (println "Got!" (<!! c)))

(println "It works!" (<!! (thread 42)))


