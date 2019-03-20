(ns threading_ppm.core)

(def head (str "P3\n" 255 " " 255" 255 " "\n"))
(def matrix 255)
(def red (->> (range matrix)
                    (map  #(mod (* % matrix) 255)
                          )))

(def green (->> (range matrix)
                (map  #(mod (* % red) 255)
                      )))
(def blue (mod (* matrix matrix)255))
;(def blue (->> (map #(mod (* red green) 255))))
(def picture (map str red " " green " " blue "\n"))
(def output
  (clojure.string/join "\n" picture))
(def result
  (str head output))


  (spit "test.ppm" result)

