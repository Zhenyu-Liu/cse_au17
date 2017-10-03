# Author: Zhenyu Liu
# Homework 2

import nltk
import sklearn
import re
import csv

nltk.download('words')
nltk.download('punkt')
nltk.download('wordnet')

from nltk.tokenize import sent_tokenize, word_tokenize, RegexpTokenizer
from sklearn.feature_extraction.text import CountVectorizer
from nltk.stem.snowball import SnowballStemmer

# combine files into one
filenames = ['imdb_labelled.txt', 'amazon_cells_labelled.txt', 'yelp_labelled.txt']
FILE = 'combined_file.txt'  # the name of combined file


# combine three file into one
def combine_files(filenames):
    with open('combined_file.txt', 'wb') as outfile:
        for fname in filenames:
            with open(fname, 'rb') as infile:
                for line in infile:
                    outfile.write(line)
            infile.close()


# split sentence from a file
def split_sentence():
    fin = open(FILE, encoding='utf-8')
    data = fin.read()
    sentence_list = data.rstrip().split('\n')
    fin.close()
    return sentence_list

# get a list of purified word sequence
def purify_sentences(sentences):
    list = []
    toker = RegexpTokenizer(r'\w+')
    stemmer = SnowballStemmer("english")
    regex = re.compile(r'\d+')
    for sent in sentences:
        list.append(','.join(stemmer.stem(w)
                             for w in toker.tokenize(sent)
                             if regex.match(w) is None))
    return list


# generate feature vector with sklearn
def generate_feature_vector(matrix):
    vectorizer = CountVectorizer(min_df=1)
    feature_vector = vectorizer.fit_transform(matrix)
    feature_name = vectorizer.get_feature_names()
    return feature_name, feature_vector.toarray()


# Main
combine_files(filenames)
sentences = split_sentence()
sentences_collection = purify_sentences(sentences)
features, vector = generate_feature_vector(sentences_collection)

with open('feature_vector.csv', 'w') as csvfile:
    writer = csv.writer(csvfile, delimiter=',', quoting=csv.QUOTE_ALL)
    for s in vector:
        writer.writerow(s)
csvfile.close()

print(features)
