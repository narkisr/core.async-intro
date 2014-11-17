(ns examples.promises
  (:require
    [clojure.core.async :refer (<!! >!! chan thread)]))

(def c (chan))

(future (println "Done" (>!! c 42)))

(future (println "Got!" (<!! c)))

(thread (println "It works!" (<!! (thread 42))))


