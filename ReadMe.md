# Naming Conventions

all values star with an x prefix

xPascalCase - public and local values

mThing - private members

kThing - final/constant values

a + x,m,k - container (axThing, amThing, akThing)

# Dependencies

JavaFX

WebView

MathJax

CommonMark


# Structure + Flow

## 1. converting md to html

takes and input .md file

extracts metadata from a yaml header

converts it to .html with commonMark and places mathJax into the script

## 2. displaying

gets the html files and displays metadata about them

selecting one of them opens it in webView


## 3. other features