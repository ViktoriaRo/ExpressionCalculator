/**
 * functionality for parsing expressions & building AST
 * the grammar:
 * expression -> relation
 * relation -> term
 * [ ("<"|">"|"=") term ]
 * term -> factor { ("+"|"-") factor }
 * factor -> primary { "*" primary }
 * primary -> integer | "(" expression ")"
 * integer -> Any integer number (literal constant)
 */
class Parser {
    private String input;
    private int counter;

    /**
     * @param input initial expression
     */
    Parser(String input) {
        this.input = input.replaceAll(" ", "");
    }

    Expression parse() {
        return parseRelation();
    }


    /**
     * @return relation or term expression
     */
    private Expression parseRelation() {
        Expression result = parseTerm();
        Relation.Opcode op = parseRelOperator();
        if (op != Relation.Opcode.none) {
            Expression right = parseTerm();
            result = new Relation(op, result, right);
        }
        return result;
    }

    /**
     * @return term or factor expression
     */
    private Expression parseTerm() {
        Expression result = parseFactor();
        Term.OpCode op = parseTermOperator();
        if (op != Term.OpCode.none) {
            Expression right = parseFactor();
            result = new Term(op, result, right);
        }
        return result;
    }

    /**
     * @return factor or primary expression
     */
    private Expression parseFactor() {
        Expression result = parsePrimary();
        if (readFactorOperator().equals("*")) {
            Expression right = parsePrimary();
            result = new Factor(result, right);
        }
        return result;
    }

    /**
     * @return either Parenthesize or integer
     */
    private Primary parsePrimary() {
        Primary result = null;
        if (Character.isDigit(nextChar()))
            result = (Primary) parseInteger();
        else if (nextChar() == '(') {
            result = new Parenthesized();
            counter++;
            ((Parenthesized) result).setExpression(parse());
            skipNextChar();
        }
        return result;
    }

    /**
     * @return parsed number
     */
    private Expression parseInteger() {
        StringBuilder s = new StringBuilder("" + input.charAt(counter));
        counter++;
        while (counter + 1 < input.length() && Character.isDigit(input.charAt(counter))) {
            s.append(input.charAt(counter));
            ++counter;
        }
        return new Number(Long.parseLong(s.toString()));
    }

    /**
     * just go to the next character
     */
    private void skipNextChar() {
        counter++;
    }

    /**
     * @return next character
     */
    private char nextChar() {
        return input.charAt(counter);
    }

    /**
     * @return operational code for the given symbol
     */
    private Relation.Opcode parseRelOperator() {
        String s = readRelOperator();
        Relation.Opcode result;
        switch (s) {
            case ("<"):
                result = Relation.Opcode.less;
                break;
            case (">"):
                result = Relation.Opcode.greater;
                break;
            case ("="):
                result = Relation.Opcode.equal;
                break;
            default:
                result = Relation.Opcode.none;
        }
        return result;
    }

    /**
     * @return operational code for the given symbol
     */
    private Term.OpCode parseTermOperator() {
        String s = readTermOperator();
        Term.OpCode result;
        switch (s) {
            case ("+"):
                result = Term.OpCode.plus;
                break;
            case ("-"):
                result = Term.OpCode.minus;
                break;
            default:
                result = Term.OpCode.none;
        }
        return result;
    }

    /**
     * read the relational operators
     * // * @return ("<"|">"|"=")
     */
    private String readRelOperator() {
        if (counter >= input.length()) return "";
            switch (input.charAt(counter)) {
                case ('<'):
                    ++counter;
                    return "<";
                case ('>'):
                    ++counter;
                    return ">";
                case ('='):
                    ++counter;
                    return "=";
                default:
                    return "";
        }
    }

    /**
     * read the term operators
     *
     * @return plus or minus
     */
    private String readTermOperator() {
        if (counter >= input.length()) return "";
        if (input.charAt(counter) != '-' && input.charAt(counter) != '+') return "";
        counter++;
        return input.charAt(counter - 1) + "";
    }

    /**
     * read the factor operators
     *
     * @return multiplication or none
     */
    private String readFactorOperator() {
        if (counter >= input.length()) return "";
        if (input.charAt(counter) != '*') return "";
        counter++;
        return input.charAt(counter - 1) + "";
    }
}