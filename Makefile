.PHONY : clean
.RECIPEPREFIX = -
clean:
- find . -name "*.class" | xargs rm