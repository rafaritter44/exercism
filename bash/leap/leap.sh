
main() {
  validate_year "$@"
  year="$1"
  if divisible_by year 400
  then
    is_leap_year=true
  elif divisible_by year 100
  then
    is_leap_year=false
  elif divisible_by year 4
  then
    is_leap_year=true
  else
    is_leap_year=false
  fi
  echo $is_leap_year
}

validate_year() {
  if ! is_year "$@"
  then
    echo "Usage: leap.sh <year>"
    exit 1
  fi
}

is_year() {
  has_one_argument "$@" && is_positive_integer "$1"
}

has_one_argument() {
  (( $# == 1 ))
}

is_positive_integer() {
  [[ $1 =~ ^[1-9][0-9]*$ ]]
}

divisible_by() {
  (( $1 % $2 == 0 ))
}

main "$@"
