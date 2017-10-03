import nltk
import sklearn
import lemmatization
import numpy as np

# nltk.download('words')
# nltk.download('punkt')
# nltk.download('wordnet')
from nltk.tokenize import sent_tokenize, word_tokenize, RegexpTokenizer
from sklearn.feature_extraction.text import CountVectorizer
from nltk.stem.snowball import SnowballStemmer

fin = open("yelp_labelled.txt", 'rb')
file = ["Wow... Loved this place.	1",
        "Crust is not good.	0",
        "Not tasty and the texture was just nasty.	0",
        "Stopped by during the late May bank holiday off Rick Steve recommendation and loved it.	1",
        "The selection on the menu was great and so were the prices.	1",
        "Now I am getting angry and I want my damn pho.	0",
        "Honeslty it didn't taste THAT fresh.)	0"]
# fout = open("test.txt", 'wb')
# vector = CountVectorizer(min_df=1)
# np.set_printoptions(threshold=np.nan)
# x = vector.fit_transform(fin).toarray()
# name = vector.get_feature_names()
# print(word_tokenize(file[0]))
# str = " Stopped by during the late May bank holiday off Rick Steve recommendation and loved it."

X = CountVectorizer(min_df=1)
x = X.fit_transform(file)
matrix1 = x.toarray()
len2 = X.get_feature_names()
S = SnowballStemmer("english")
# toker = RegexpTokenizer(r'\w+')
# s = toker.tokenize(len2)
print(S.stem())
# print(lemmatization.max_match("theyarebirds"))
# print(len2)
fin.close()
# fout.close()
