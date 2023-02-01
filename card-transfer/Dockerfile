FROM node:14.5.0-alpine

COPY / .

RUN npm install
RUN npm rebuild node-sass

EXPOSE 3000

CMD [ "npm", "start", "run" ]




