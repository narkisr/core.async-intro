(ns examples.pubsub
  (:require
    [clojure.core.async :refer (<!! >!! chan pub sub go <! >! close!)])
 )

(def to-pub (chan 1))
(def p (pub to-pub :type))

(let [c (chan 1)]
  (sub p :error c)
  (go 
    (while true
      (when-let [e (<! c)]
       (println "got an error" e)))))

(let [c (chan 1)]
  (sub p :warn c)
  (go 
    (while true
      (when-let [w (<! c)]
       (println "got a warning" w)))))

(>!! to-pub {:type :error :msg "bad thing"})

(close! to-pub)
