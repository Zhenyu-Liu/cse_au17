from nltk.stem import WordNetLemmatizer
from nltk.corpus import words

wordlist = set(words.words())
wordnet_lemmatizer = WordNetLemmatizer()


def max_match(text):
    pos2 = len(text)
    result = ''
    while len(text) > 0:
        word = wordnet_lemmatizer.lemmatize(text[0:pos2])
        if word in wordlist:
            result = result + text[0:pos2] + ' '
            text = text[pos2:]
            pos2 = len(text)
        else:
            pos2 = pos2 - 1
    return result[0:-1]