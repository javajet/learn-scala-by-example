import random

""" 
Basic Cup of Tea

"""


def create_drink(cup, flavour):
    cup.append(flavour)
    return cup


def add_water(water, drink):
    drink.append(water)


def add_milk(milk, drink):
    drink.append(milk)


def add_sugar(sugar, drink):
    drink.append(sugar)


def stir(drink):
    random.shuffle(drink)


def main():

    cup = []
    flavour = 'Tea'
    drink = create_drink(cup, flavour)

    add_water('Hot Water', drink)
    add_milk('Semi-Skimmed Milk', drink)
    add_sugar('No Sugar', drink)

    stir(drink)

    print ', '.join(drink)


if __name__ == '__main__':
    main()

'''

    if ( isValid(input) )
        result = doSomething(input)
        if ( result.isSuccess )
            nextResult = doSomethingElse(result)
            if ( nextResult.isSuccess )
                anotherResult = doAnotherThing(nextResult)
                if ( anotherResult.isValid )
                    moreStuff = doStuff(anotherResult)
                    if ( moreStuff.isSuccess )
                        confusedYet = doThing(moreStuff)
                        if ( confusedYet.isValid )
                            ...
                        else 
                            doOtherThing(confusedYet)
                    else 
                        doOtherStuff(anotherResult)
                else 
                    doOtherAnotherThing(anotherResult)
            else
                doOtherSomethingElse(nextResult)
        else
            doOtherSomething(result)
    else
        doOther(input)

'''
