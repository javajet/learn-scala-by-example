import random

""" 
OO Cup of Tea w/Validation

"""


class Flavour:
    """
    Represents the flavour of a drink or type of beverage.

    Used when making a drink.

    """

    def __init__(self, name):
        """
        Create a Beverage Type

        :param name: name of the beverage
        """
        self.name = name

    def __str__(self):
        """
        A string version of the beverage type

        :return: the name of the beverage
        """
        return self.name


class Water:
    """
    Represents water.

    Used when making a drink.

    """

    def __init__(self, name):
        """
        Create some water

        :param name: description of the water
        """
        self.name = name

    def is_hot(self):
        """
        Check if the water is hot

        :return: true if the water is hot
        """
        return 'Hot' in self.name

    def __str__(self):
        """
        A string version of this water

        :return: the description of this water
        """
        return self.name


class Milk:
    """
    Represents some milk.

    Used when making a drink.

    """

    def __init__(self, name):
        """
        Create some milk

        :param name: the description of this milk
        """
        self.name = name

    def is_off(self):
        """
        Check whether the milk is okay to drink

        :return: true if the milk is soured
        """
        return self is Milk.BAD_MILK

    def __str__(self):
        """
        A string version of this milk

        :return: the description of this milk
        """
        return self.name

    def __eq__(self, other):
        """
        Compares two milks

        :param other: the milk to compare
        :return: true if the milk is the same
        """
        return self.__dict__ == other.__dict__


"""
An instance of sour milk 
"""
Milk.BAD_MILK = Milk('Gone Bad')


class Sugar:
    """
    Represents some sugar.

    Used when making a drink.

    """

    def __init__(self, name):
        """
        Create some sugar

        :param name: the description of this sugar
        """
        self.name = name

    def __str__(self):
        """
       A string version of this sugar

       :return: the description of this sugar
       """
        return self.name

    def __eq__(self, other):
        """
        Compares two sugars

        :param other: the sugar to compare
        :return: true if the sugar is the same
        """
        return self.__dict__ == other.__dict__

    def is_valid(self):
        """
        Is this sugar valid?

        :return: true if the sugar is valid
        """
        return self is not Sugar.INVALID_SUGAR


"""
An invalid instance of sugar
"""
Sugar.INVALID_SUGAR = Sugar('Salt')


class Drink:
    """
    Represents a drink or beverage to be made

    """

    def __init__(self, beverage_type):
        """
        Create a basic drink with nothing added

        :param beverage_type: the flavour of the drink
        """
        self.ingredients = []
        self.ingredients.append(beverage_type)

    def with_water(self, water):
        """
        Add some water to the drink

        :param water: water to add
        :return: the drink with water added
        """
        self.ingredients.append(water)
        return self

    def with_milk(self, milk):
        """
        Add some milk to the drink

        :param milk: milk to add
        :return: the drink with milk added
        """
        self.ingredients.append(milk)
        return self

    def with_sugar(self, sugar):
        """
        Add some sugar to the drink.

        :param sugar: sugar to add
        :return: the drink with sugar added
        :raises ValueError: if the sugar is invalid
        """
        if sugar.is_valid():
            self.ingredients.append(sugar)
            return self
        else:
            raise ValueError('ERROR: Wrong Sugar')

    def stir(self):
        """
        Mixes up the drink

        :return: the stirred drink (not shaken)
        """
        random.shuffle(self.ingredients)
        return self

    def __str__(self):
        """
        A string version of this drink

        :return: the description of this drink
        """
        ingredient_names = [str(ingredient) for ingredient in self.ingredients]
        return ', '.join(ingredient_names)


def make_drink(beverage_type, water, milk, sugar):
    """
    The main process for making a cup of tea
    (algorithm, perhaps?)

    :param beverage_type: flavour of the drink
    :param water: chief ingredient
    :param milk: add to taste
    :param sugar: optional if desired
    :return: lovely brew
    """

    drink = Drink(beverage_type)
    if water.is_hot():
        drink.with_water(water)
        if not milk.is_off():
            drink.with_milk(milk)
            try:
                drink.with_sugar(sugar)
            except ValueError as e:
                return e.message

            drink.stir()

            return drink
        else:
            return 'ERROR: Bad Milk'
    else:
        return 'ERROR: Cold Water'


def main():
    """
    Start the tea-making process.

    Prints to the console:
    - the finished drink
    - with sour milk
    - with invalid sugar


    :return: nothing
    """

    tea_bag = Flavour('Tea')
    hot_water = Water('Hot Water')
    semi_skimmed = Milk('Semi-Skimmed Milk')
    no_sugar = Sugar('No Sugar')

    print make_drink(tea_bag, hot_water, semi_skimmed, no_sugar)

    sour_milk = Milk.BAD_MILK
    print make_drink(tea_bag, hot_water, sour_milk, no_sugar)

    salt = Sugar.INVALID_SUGAR
    print make_drink(tea_bag, hot_water, semi_skimmed, salt)


if __name__ == '__main__':
    main()
