(ns ^:figwheel-hooks medicina-interna.main
  (:require
    [reagent.dom :as r.dom]))

(defn app [] [:h1 "Seja bem vindo!"])

(defn mount []
  (r.dom/render [app] (js/document.getElementById "root")))

(defn ^:after-load re-render []
  (mount))

(defonce start-up (do (mount) true))
