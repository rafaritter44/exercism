
main() {
  name=$(get_name "$@")
  echo "One for ${name}, one for me."
}

get_name() {
  name="$@"
  if [ -z "$name" ]
  then
    name="you"
  fi
  echo "$name"
}

main "$@"
